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
            <div className='icon'>
                <p className="material-icons md-36" onClick={LoginClick}>
                    person_outline
                </p>
            </div>
            <div className='icon'>
                <span class="material-icons md-36">
                    calendar_today
                </span>
            </div>
            <div className='icon'>
                <span className="material-icons md-36">
                    notifications
                </span>
            </div>
        </header>
    );
}

export default Header;