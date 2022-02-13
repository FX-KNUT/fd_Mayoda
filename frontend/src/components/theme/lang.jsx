import { useRecoilState } from 'recoil';
import { useEffect } from 'react';
import { langState } from '../../recoil/atom';
import React from 'react';
import { useTranslation } from 'react-i18next';

const LangSelect = () => {
  const [lang, setlang] = useRecoilState(langState);
  const { t, i18n } = useTranslation();

  const onChangelang = (e) => {
    setlang(i18n.changeLanguage(e.target.value));
  };

  useEffect(() => {
    localStorage.setItem('langState', lang);
  }, [lang]);

  return (
    <div>
      <h1>{t('title')}</h1>
      <select name="selectlang" onChange={onChangelang}>
        <option value="en">ENGLISH</option>
        <option value="kr">한국어</option>
      </select>
    </div>
  );
};

export { LangSelect };
