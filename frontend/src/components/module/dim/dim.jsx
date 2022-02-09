import { useState } from "react";
import "./dim.css";

const Dim = ({childComponent, show}) => {

    const [showState, setShowState] = useState(show);

    return (
        <div 
            className={'module_dim' + showState === true ? 'dim_show' : 'dim_hide'}
            onClick={() => setShowState(prev => !prev)}    
        >
            {childComponent}
        </div>
    );
}

export default Dim;