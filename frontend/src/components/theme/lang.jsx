import { useRecoilState } from 'recoil';
import { useEffect } from 'react';
import { langState } from '../../recoil/atom';
import React from 'react';
import { useTranslation } from 'react-i18next';

const LangSelect = () => {
  const [lang, setlang] = useRecoilState(langState);
  const { i18n, seti18n } = useTranslation();

  const onChangelang = (e) => {
    setlang(seti18n.changeLanguage(e.target.value));
  };

  useEffect(() => {
    localStorage.setItem('langState', lang);
  }, [lang]);

  /* select 를 통해서 변환하고 싶은 단어는 i18n을 통해서 적어야 함 */
  return (
    <div>
      <h1>{i18n('title')}</h1>
      <select name="selectlang" onChange={onChangelang}>
        <option value="en">ENGLISH</option>
        <option value="kr">한국어</option>
      </select>
    </div>
  );
};

export { LangSelect };
