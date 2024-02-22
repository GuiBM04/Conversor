import { ChangeEvent, useEffect, useState } from "react";

interface Coin {
    id: number,
    name: string,
    value: number;
}

const Conversor = () => {
    const [coins, setCoins] = useState<Coin[]>([]);
    const [selectedCoin, setSelectedCoin] = useState<string>('');

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
        }
    };

    fetchCoins();
    }, []);



    const [value, setValue] = useState<number>(0);
    const [returnedValue, setReturnedValue] = useState<number>(0);

    const handleValueChange = (event: ChangeEvent<HTMLInputElement>) => {
        setValue(Number(event.target.value));

        // fetch GET e setReturnedValue()
    }

    return (
        <section>
            <h2>Converter</h2>

            <div>
                <label htmlFor="coinSelect">Selecione uma moeda:</label>
                <select id="coinSelect" value={selectedCoin} onChange={(e) => setSelectedCoin(e.target.value)}>
                    <option value="">Selecione...</option>
                    {coins.map((coin) => (
                        <option key={coin.id} value={coin.name}>
                            {coin.name}
                        </option>
                    ))}
                </select>
                {selectedCoin && <p>Você selecionou: {selectedCoin}</p>}
            </div>

            <label>Valor</label>
            <input
                className="input-value"
                id="value"
                type="number"
                value={value !== undefined ? value : ""}
                onChange={handleValueChange}
                placeholder="Digite um valor numérico"
            />

            <label>Resultado</label>
            <input
                className="input-return"
                id="returnedInput"
                type="text"
                value={returnedValue}
                disabled
            />
        </section>
    );
}

export default Conversor;