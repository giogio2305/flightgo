"use client"
import React, { useState } from 'react';
import clsx from 'clsx';
import { format, parseISO } from 'date-fns';
import { fr } from 'date-fns/locale'; // Importer la locale française

function DatePick({ placeholder, id }) {
  const [date, setDate] = useState('');
  const [inputType, setInputType] = useState('text');

  const handleChange = (event) => {
    const value = event.target.value;
    // Vérifier si la valeur correspond au format jj/mm/aaaa
    const regex = /^\d{0,2}\/\d{0,2}\/\d{0,4}$/; // Permettre une saisie progressive
    if (regex.test(value) || value === '') {
      setDate(value);
    }
  };

  const handleFocus = () => {
    // Convertir la date au format ISO pour le type date
    const [day, month, year] = date.split('/');
    if (day && month && year) {
      setDate(`${year}-${month}-${day}`); // Format ISO
    }
    setInputType('date');
  };

  const handleBlur = () => {
    // Convertir la date au format français
    const [year, month, day] = date.split('-');
    if (year && month && day) {
      const formattedDate = format(parseISO(`${year}-${month}-${day}`), "EEEE d MMMM yyyy", { locale: fr }); // Format avec jour et mois en français
      setDate(formattedDate); // Mettre à jour l'état avec la date formatée
    }
    setInputType('text');
  };

  const handleDateChange = (event) => {
    const value = event.target.value; // Récupérer la date au format ISO
    setDate(format(parseISO(value), "d MMMM yyyy", { locale: fr })); // Mettre à jour l'état avec la date formatée
  };

  return (
    <input 
      className={clsx(
        'w-[50%] rounded-sm border-none bg-transparent py-0.5 pr-2 pl-2 text-sm/5 text-white',
        'focus:outline-none data-[focus]:outline-2 data-[focus]:-outline-offset-2 data-[focus]:outline-white/25'
      )}
      placeholder={placeholder}
      id={id}
      type={inputType}
      value={date}
      onChange={inputType === 'date' ? handleDateChange : handleChange} // Utiliser le bon gestionnaire
      onFocus={handleFocus}
      onBlur={handleBlur}
    />
  );
}

export default DatePick;