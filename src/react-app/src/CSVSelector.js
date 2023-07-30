import React, { useState, optionsState } from "react";
import Papa from "papaparse";
import { ButtonGroup } from "react-bootstrap";
import './CSVSelector.css';

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
    const [transactionsCompany, setTransactionsCompany] = useState([]);
    const [transactionsAmount, setTransactionsAmount] = useState([]);

    const [transactionsCategory, setTransactionsCategory] = useState([]);

    const [transactionsIndex, setTransactionsIndex] = useState(0);

    function handleNextTransaction() {
        setTransactionsCategory(old => [...old, selectedCategory]);
        setTransactionsIndex(old => old + 1);
    }
    const [selectedCategory, setSelectedCategory] = useState("");

    // This state will store the parsed data
    const [data, setData] = useState([]);

    // It state will contain the error when
    // correct file extension is not used
    const [error, setError] = useState("");

    // It will store the file uploaded by the user
    const [file, setFile] = useState("");

    function indexToSingleTransactionDisplay(index) {

        return (
            <div className="SingleTransactionDisplay">
                <h3>Company:</h3>
                <p>{transactionsCompany[index]}</p>
                <h3>Amount:</h3>
                <p>{transactionsAmount[index]}</p>
            </div>
        )
    }


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

        // reset state variables
        setTransactionsAmount([]);
        setTransactionsCategory([]);
        setTransactionsCompany([]);
        setTransactionsIndex(0);

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
                        setTransactionsCompany(oldArray => [...oldArray, parsedData[i]["Description"]]);
                        setTransactionsAmount(oldArray => [...oldArray, parsedData[i]["Amount"]]);
                    }
                }
            } else {
                for (let i = 0; i < parsedData.length - 1; i++) {
                    if (parsedData[i]["Transaction Date"] != "") {
                        setTransactionsCompany(oldArray => [...oldArray, parsedData[i]["Description"]]);
                        if (parsedData[i]["Debit"] === "") {
                            setTransactionsAmount(oldArray => [...oldArray, 0 - parsedData[i]["Credit"]]);
                        } else {
                            setTransactionsAmount(oldArray => [...oldArray, parsedData[i]["Debit"]]);
                        }
                    }
                }
            }
        };
        reader.readAsText(file);
    };


    function exportToCsv(filename, rows) {
        var processRow = function (row) {
            var finalVal = '';
            for (var j = 0; j < row.length; j++) {
                var innerValue = row[j] === null ? '' : row[j].toString();
                if (row[j] instanceof Date) {
                    innerValue = row[j].toLocaleString();
                };
                var result = innerValue.replace(/"/g, '""');
                if (result.search(/("|,|\n)/g) >= 0)
                    result = '"' + result + '"';
                if (j > 0)
                    finalVal += ',';
                finalVal += result;
            }
            return finalVal + '\n';
        };

        var csvFile = processRow(rows);


        var blob = new Blob([csvFile], { type: 'text/csv;charset=utf-8;' });
        if (navigator.msSaveBlob) { // IE 10+
            navigator.msSaveBlob(blob, filename);
        } else {
            var link = document.createElement("a");
            if (link.download !== undefined) { // feature detection
                // Browsers that support HTML5 download attribute
                var url = URL.createObjectURL(blob);
                link.setAttribute("href", url);
                link.setAttribute("download", filename);
                link.style.visibility = 'hidden';
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
            }
        }
    }

    return (
        <div className="CSVSelector">
            <div className="section creditCardType">
                {isDiscoverToString()}
                <div>
                    <button className="creditCardTypeButton" onClick={() => setIsDiscover(!(isDiscover))}>Change Credit Card Company</button>
                </div>
            </div>
            <div className="CSVProccessing section">
                <h2 htmlFor="csvInput" style={{ display: "block" }}>
                    Enter CSV File
                </h2>
                <div className="choose-file-container">
                    <input
                        onChange={handleFileChange}
                        id="csvInput"
                        name="file"
                        type="File"
                    />
                </div>
                <div>
                    <button onClick={handleParse}>Parse</button>
                </div>
            </div>

            <div className="section ">
                {transactionsIndex < transactionsAmount.length && indexToSingleTransactionDisplay(transactionsIndex)}
                <h2>{selectedCategory}</h2>
                {transactionsIndex < transactionsAmount.length && <div className="categoryButtonsContainer">
                    <button className="category-button" onClick={() => setSelectedCategory("Subscriptions")}>Subscriptions</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Groceries")}>Groceries</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Coffee")}>Coffee</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Tea")}>Tea</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Food Delivery")}>Food Dilivery</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Dining Out")}>Dining Out</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Toiletries")}>Toiletries</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Electricity/Wifi Bill")}>Electricity/Wifi Bill</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Fun/Activities")}>Activities</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Public Transportation")}>Public Transportation</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Uber/Lyft/Other")}>Uber/Lyft/Other</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Clothes")}>Clothes</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Medical")}>Medical</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Home")}>Home</button>
                    <button className="category-button" onClick={() => setSelectedCategory("Other")}>Other</button>
                </div >}
                {transactionsIndex < transactionsAmount.length && <button onClick={handleNextTransaction}>Next Transaction</button>}
                {transactionsIndex === transactionsAmount.length && transactionsIndex !== 0 && <h2>Done! Download CSV of Categories Below</h2>}
                <div>
                    {transactionsIndex === transactionsAmount.length && transactionsIndex !== 0 && <button onClick={() => exportToCsv("categories_for_" + file.name, transactionsCategory)}>Download CSV of Categories</button>}
                </div>
            </div>

        </div >
    );
};

export default CSVSelector;