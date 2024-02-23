import React, { useState } from 'react';
import './App.css';
import CoinManager from './components/CoinManager';
import Conversor from './components/Conversor';

const App: React.FC = () => {
    const [updateCoins, setUpdateCoins] = useState<number>(0);

    const handleSetUpdateCoins = () => {
        setUpdateCoins((prev) => prev + 1);
    }

    return (
        <div className="App">
            <header>
                <h1>Conversor de Moedas</h1>
            </header>
            <CoinManager onUpdate={handleSetUpdateCoins} onAddCoin={handleSetUpdateCoins} />
            <Conversor onUpdate={handleSetUpdateCoins} />
        </div>
    );
}

export default App;