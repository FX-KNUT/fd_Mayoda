import { atom } from 'recoil';

const userState = atom({
  key: 'userState',
  default: localStorage.getItem('userState'),
});

// 화면 모드 상태를 위한 atom dark와 light 2종류가 있음
const themeState = atom({
  key: 'themeState',
  default: localStorage.getItem('themeState') ? 'dark' : 'light',
});

// 언어상태를 위한 atom
const langState = atom({
  key: 'langState',
  default: localStorage.getItem('langState'),
});

export { userState, themeState, langState };
