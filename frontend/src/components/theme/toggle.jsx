import { useRecoilState } from 'recoil';
import { themeState } from '../../recoil/atom';
import { useEffect } from 'react';

const Toggle = () => {
  const [theme, setTheme] = useRecoilState(themeState);

  const onChangeTheme = () => {
    setTheme(theme === 'dark' ? 'light' : 'dark');
  };

  useEffect(() => {
    localStorage.setItem('themeState', theme);
  }, [theme]);

  return <input type="checkbox" name="toggleTheme" onChange={onChangeTheme} />;
};

export default Toggle;
