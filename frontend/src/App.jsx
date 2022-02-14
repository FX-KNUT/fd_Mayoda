import './App.css';
import Header from './components/header/header';
import Main from './components/main/main';
import Toggle from './components/theme/toggle';
import { useRecoilValue } from 'recoil';
import { themeState } from './recoil/atom';
import { LangSelect } from './components/theme/lang';

function App() {
  const theme = useRecoilValue(themeState);
  return (
    <div className={theme}>
      <Header />
      <Toggle />
      <LangSelect />
      <Main />
    </div>
  );
}

export default App;
