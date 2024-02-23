import { FormEvent } from "react";


const RemoveCoins: React.FC = () => {
    // codigo parecido com o do conversor

    const handleSubmit = (event: FormEvent) => {
        // codigo praticamente igual do conversor
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <h3>Remover Moeda</h3>

                <label>Selecione a moeda: </label>
                <select>
                    {/* codigo parecido com o do conversor */}
                </select>
            </form>
        </div>
    );
}

export default RemoveCoins;