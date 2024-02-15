import './App.css';
import AddCoin from './components/AddCoin';
import Conversor from './components/Conversor';

function App() {
    

    return (
        <div className="App">

            <header>
                <h1>Conversor de Moedas</h1>
            </header>

            <AddCoin/>

            <Conversor/>

        </div>
    );
}

export default App;