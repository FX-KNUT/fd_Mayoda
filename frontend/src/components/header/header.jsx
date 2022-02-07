import './header.css';
import 'material-icons/iconfont/material-icons.css';

function LoginClick(){
    console.log("로그인 창 뿅!!!")
}

function Header() {
    return (
        <header className='header_container'>
            <p className='header_logo'> MAYODA </p>
            <p className='header_space'></p>
            <div className='header_icon' role='button'>
                <p className="material-icons md-36"  onClick={LoginClick} >
                    person_outline
                </p>
            </div>
            <div className='header_icon' role='button'>
                <p class="material-icons md-36">
                    calendar_today
                </p>
            </div>
            <div className='header_icon' role='button'>
                <p className="material-icons md-36"  >
                    notifications
                </p>
            </div>
        </header>
    );
}

export default Header;