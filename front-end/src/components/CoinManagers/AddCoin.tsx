import React, { ChangeEvent, FormEvent, useState } from "react";

interface AddCoinProps {
    onAddCoin: () => void;
}

const AddCoin: React.FC<AddCoinProps> = ({ onAddCoin }) => {
    const [coinToAdd, setCoinToAdd] = useState<string>('');
    const [valueOfCoin, setValueOfCoin] = useState<number>(0);

    const handleCoinChange = (event: ChangeEvent<HTMLInputElement>) => {
        setCoinToAdd(event.target.value);
    }

    const handleValueOfCoinChange = (event: ChangeEvent<HTMLInputElement>) => {
        setValueOfCoin(Number(event.target.value));
    }

    const handleSubmit = async (event: FormEvent) => {
        event.preventDefault();

        const coin = {
            name: coinToAdd,
            value: valueOfCoin
        }

        try {
            const response = await fetch('http://localhost:8080/api/add-coin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(coin),
            });

            if (response.ok) {
                console.log('Coin sent successfully!');
                onAddCoin(); // Chama a função de atualização
            } else {
                console.error('Failed to send coin to API');
            }
        } catch (error) {
            console.error('Error sending coin to API:', error);
        }
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <h3>Adicionar Moeda</h3>

                <label>Nome da Moeda</label>
                <input
                    id='coinToAdd'
                    type="text"
                    value={coinToAdd}
                    onChange={handleCoinChange}
                    placeholder="Digite o nome da moeda"
                />

                <label>Valor da Moeda em Real</label>
                <input
                    id='valueOfCoinToAdd'
                    type="number"
                    value={valueOfCoin}
                    onChange={handleValueOfCoinChange}
                    placeholder="Valor de Referência"
                />

                <input type="submit"/>
            </form>
        </div>
    );
}

export default AddCoin;
