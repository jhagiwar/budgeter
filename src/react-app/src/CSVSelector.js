import React, { useState } from "react";
import Papa from "papaparse";

// Allowed extensions for input file
const allowedExtensions = ["csv"];

const CSVSelector = () => {


    // This state will store Discover or Capital One
    const [isDiscover, setIsDiscover] = useState(true);

    function isDiscoverToString() {
        if (isDiscover) {
            return <h2> Discover CSV</h2>;
        } else {
            return <h2>Capital One CSV </h2>;
        }
    }

    // This state will store the Category Ids,CompanyNames, and Amount in order 
    const [transactionsIds, setTransationsIds] = useState([]);
    const [transactionsCompany, setTransationsCompany] = useState([]);
    const [transactionsAmount, setTransationsAmount] = useState([]);

    // This state will store the parsed data
    const [data, setData] = useState([]);

    // It state will contain the error when
    // correct file extension is not used
    const [error, setError] = useState("");

    // It will store the file uploaded by the user
    const [file, setFile] = useState("");

    // This function will be called when
    // the file input changes
    const handleFileChange = (e) => {
        setError("");

        // Check if user has entered the file
        if (e.target.files.length) {
            const inputFile = e.target.files[0];

            // Check the file extensions, if it not
            // included in the allowed extensions
            // we show the error
            const fileExtension = inputFile?.type.split("/")[1];
            if (!allowedExtensions.includes(fileExtension)) {
                setError("Please input a csv file");
                return;
            }

            // If input type is correct set the state
            setFile(inputFile);
        }
    };
    const handleParse = () => {

        // If user clicks the parse button without
        // a file we show a error
        if (!file) return setError("Enter a valid file");

        // Initialize a reader which allows user
        // to read any file or blob.
        const reader = new FileReader();

        // Event listener on reader when the file
        // loads, we parse it and set the data.


        reader.onload = async ({ target }) => {
            const csv = Papa.parse(target.result, { header: true });
            const parsedData = csv?.data;
            if (isDiscover) {
                for (let i = 0; i < parsedData.length - 1; i++) {
                    if (parsedData[i]["Description"] !== undefined) {
                        setTransationsCompany(oldArray => [...oldArray, parsedData[i]["Description"]]);
                        setTransationsAmount(oldArray => [...oldArray, parsedData[i]["Amount"]]);
                    }
                }
            }
        };
        reader.readAsText(file);
    };

    return (
        <div>
            <div className="creditCardType">
                {isDiscoverToString()}
                <div>
                    <button onClick={() => setIsDiscover(!(isDiscover))}>Change Credit Card Company</button>
                </div>
            </div>
            <div className="CSV Proccessing">
                <h2 htmlFor="csvInput" style={{ display: "block" }}>
                    Enter CSV File
                </h2>
                <input
                    onChange={handleFileChange}
                    id="csvInput"
                    name="file"
                    type="File"
                />
                <div>
                    <button onClick={handleParse}>Parse</button>
                </div>
            </div>
            <div style={{ marginTop: "3rem" }}>
                {error ? error : transactionsCompany.map((col,
                    idx) => <div key={idx}>{col}</div>)}
            </div>
            <div style={{ marginTop: "3rem" }}>
                {error ? error : transactionsAmount.map((col,
                    idx) => <div key={idx}>{col}</div>)}
            </div>
        </div>
    );
};

export default CSVSelector;