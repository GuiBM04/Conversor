import { ChangeEvent, useState } from "react";

const Conversor = () => {
    const [value, setValue] = useState<number>(0);
    const [returnedValue, setReturnedValue] = useState<number>(0);

    const handleValueChange = (event: ChangeEvent<HTMLInputElement>) => {
        setValue(Number(event.target.value));

        // fetch GET e setReturnedValue()
    }

    return (
        <section>
            <h2>Converter</h2>

            <label>Selecione o tipo de moeda</label>
            <select>
                <option/>
                <option/>
		        <option/>
	        </select>

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