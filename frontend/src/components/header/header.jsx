import './header.css';
import 'material-icons/iconfont/material-icons.css';

function LoginClick(){
    console.log("로그인 창 뿅!!!")
}

function Header() {
    return (
        <header className='container'>
            <p className='logo'> MAYODA </p>
            <p className='space'></p>
            <div className='icon' role="button">
                <p className="material-icons md-36" draggable="false" onClick={LoginClick}>
                    person_outline
                </p>
            </div>
            <div className='icon' role="button">
                <p class="material-icons md-36" draggable="false">
                    calendar_today
                </p>
            </div>
            <div className='icon' role="button">
                <p className="material-icons md-36" draggable="false">
                    notifications
                </p>
            </div>
        </header>
    );
}

export default Header;