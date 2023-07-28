import logo from './logo.svg';
import './App.css';
import CategoryButton from './CategoryButton';
import CSVSelector from './CSVSelector';

function App() {
  return (
    <div className="App">
      <div className="App-header">
        <h1>Budgeting App</h1>
      </div>
      <div className='CSVParser'>
        <CSVSelector />
      </div>
      <CategoryButton />
    </div>
  );
}

export default App;
