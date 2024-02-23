import React from "react";
import AddCoin from "./CoinManagers/AddCoin";
import RemoveCoins from "./CoinManagers/RemoveCoin";

interface CoinManagerProps {
    onUpdate: () => void;
    onAddCoin: () => void;
}

const CoinManager: React.FC<CoinManagerProps> = ({ onUpdate, onAddCoin }) => {

    return (
        <div>
            <h2>Gerenciador de Moeda</h2>
            <AddCoin onAddCoin={() => onAddCoin()} />
            <RemoveCoins/>
        </div>
    );
}

export default CoinManager;