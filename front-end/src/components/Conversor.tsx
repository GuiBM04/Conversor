import React, { useEffect, useState } from "react";

interface ConversorProps {
    onUpdate: () => void;
}

interface Coin {
    id: number;
    name: string;
    value: number;
}

const Conversor: React.FC<ConversorProps> = ({ onUpdate }) => {
    const [coins, setCoins] = useState<Coin[]>([]);
    const [selectedCoin, setSelectedCoin] = useState<string>('');
    const [targetCoin, setTargetCoin] = useState<string>('');
    const [value, setValue] = useState<number>(0);
    const [convertedValue, setConvertedValue] = useState<number>(0);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchCoins = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/coins');
                if (!response.ok) {
                    throw new Error(`Erro ao buscar moedas: ${response.statusText}`);
                }
                const data = await response.json();
                setCoins(data);
            } catch (error) {
                console.error('Erro ao buscar moedas:', error);
                setError('Erro ao buscar moedas. Tente novamente.');
            }
        };

        fetchCoins();
    }, [onUpdate]);

    useEffect(() => {
        if (selectedCoin && targetCoin) {
            const base = coins.find((coin) => coin.name === selectedCoin)?.value;
            const target = coins.find((coin) => coin.name === targetCoin)?.value;

            if (base !== undefined && target !== undefined && value !== undefined) {
                const convertedValue = ((base / target) * value).toFixed(2);
                setConvertedValue(parseFloat(convertedValue));
            }
        }
    }, [value, selectedCoin, targetCoin, coins]);

    return (
        <section>
            <h2>Converter</h2>

            <div>
                <label htmlFor="coinSelect">Selecione:</label>
                <select className="coinSelect" value={selectedCoin} onChange={(e) => setSelectedCoin(e.target.value)}>
                    <option value="">Base...</option>
                    {coins.map((coin) => (
                        <option key={coin.id} value={coin.name}>
                            {coin.name}
                        </option>
                    ))}
                </select>

                <label> =&gt; </label>
                <select className="coinSelect"
                        value={targetCoin}
                        onChange={(e) => setTargetCoin(e.target.value)}
                        disabled={!selectedCoin}>
                    {selectedCoin ? (
                        <>
                            <option value="" disabled>Alvo...</option>
                            {coins
                                .filter((coin) => coin.name !== selectedCoin)
                                .map((coin) => (
                                    <option key={coin.id} value={coin.name}>
                                        {coin.name}
                                    </option>
                                ))}
                        </>
                    ) : (
                        <option value="" disabled>Alvo...</option>
                    )}
                </select>
            </div>

            <label>Valor</label>
            <input
                className="input-value"
                id="value"
                type="number"
                value={value !== undefined ? value : 0}
                onChange={(e) => setValue(parseFloat(e.target.value))}
                placeholder="Digite um valor numérico"
            />

            <label>Resultado</label>
            <input
                className="input-return"
                id="returnedInput"
                type="text"
                value={convertedValue}
                disabled
            />
        </section>
    );
}

export default Conversor;
