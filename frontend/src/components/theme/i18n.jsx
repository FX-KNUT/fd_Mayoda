import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

// 더욱 많은 언어 사용가능
const resources = {
  en: {
    translation: {
      title: 'MAYODA',
    },
  },
  kr: {
    translation: {
      title: '마요다',
    },
  },
};

i18n.use(initReactI18next).init({
  resources,
  lng: 'en',
});

export { i18n };
