import { ChangeEvent, FormEvent, useState } from "react";

const AddCoin = () => {
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

        // fetch POST
    }

    return (
        <form onSubmit={handleSubmit}>
            <h2>Adicionar Moedas</h2>

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
    );
}

export default AddCoin;