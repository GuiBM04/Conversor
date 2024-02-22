import { useState } from 'react';
import './App.css';
import AddCoin from './components/AddCoin';
import Conversor from './components/Conversor';

const App: React.FC = () => {
    const [updateEffect, setUpdateEffect] = useState<number>(0);

    const handleAddCoinSubmit = () => {
        setUpdateEffect((prev) => prev + 1);
    };

    const handleCoinSelectionChange = () => {
        setUpdateEffect((prev) => prev + 1);
    };

    return (
        <div className="App">
            <header>
                <h1>Conversor de Moedas</h1>
            </header>
            <AddCoin onSubmit={handleAddCoinSubmit} />
            <Conversor updateEffect={handleCoinSelectionChange} />
        </div>
    );
}

export default App;