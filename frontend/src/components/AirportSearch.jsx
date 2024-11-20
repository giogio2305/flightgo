// components/AirportSearch.js
'use client'
// components/AirportSearch.js
import { useState, useEffect } from 'react';
import { Combobox, ComboboxButton, ComboboxInput, ComboboxOption, ComboboxOptions } from '@headlessui/react'
import { CheckIcon, ChevronDownIcon } from '@heroicons/react/20/solid'
import clsx from 'clsx'

const AirportSearch = ({placeholder}) => {
  const [query, setQuery] = useState('');
  const [airports, setAirports] = useState([]);
  const [loading, setLoading] = useState(false);

  const fakeIataAirpotsData = [
    { id: 1, name: 'Hartsfield-Jackson Atlanta International Airport', icao: 'KATL', iata: 'ATL', city: 'Atlanta' },
    { id: 2, name: 'Los Angeles International Airport', icao: 'KLAX', iata: 'LAX', city: 'Los Angeles' },
    { id: 3, name: "Chicago O'Hare International Airport", icao: 'KORD', iata: 'ORD', city: 'Chicago' },
    { id: 4, name: 'Dallas/Fort Worth International Airport', icao: 'KDFW', iata: 'DFW', city: 'Dallas' },
    { id: 5, name: 'Denver International Airport', icao: 'KDEN', iata: 'DEN', city: 'Denver' },
    { id: 6, name: 'O.R. Tambo International Airport', icao: 'FAOR', iata: 'JNB', city: 'Johannesburg' },
    { id: 7, name: 'Cairo International Airport', icao: 'HECA', iata: 'CAI', city: 'Cairo' },
    { id: 8, name: 'Murtala Muhammed International Airport', icao: 'DNMM', iata: 'LOS', city: 'Lagos' },
    { id: 9, name: 'Jomo Kenyatta International Airport', icao: 'HKJK', iata: 'NBO', city: 'Nairobi' },
    { id: 10, name: 'Cape Town International Airport', icao: 'FACT', iata: 'CPT', city: 'Cape Town' },
    { id: 11, name: 'Douala International Airport', icao: 'FKKD', iata: 'DLA', city: 'Douala' },
    { id: 12, name: 'Yaoundé Nsimalen International Airport', icao: 'FKYS', iata: 'NSI', city: 'Yaoundé' },
    { id: 13, name: 'N\'Djamena International Airport', icao: 'FTTJ', iata: 'NDJ', city: 'N\'Djamena' },
    { id: 14, name: 'Libreville International Airport', icao: 'FOOL', iata: 'LBV', city: 'Libreville' },
    { id: 15, name: 'Brazzaville Maya-Maya Airport', icao: 'FCBB', iata: 'BZV', city: 'Brazzaville' },
  ];

  useEffect(() => {
    setAirports(fakeIataAirpotsData); // Initialiser avec les données fictives au chargement du composant
  }, []); // Le tableau vide signifie que cela s'exécute une seule fois au montage

  const handleChange = (event) => {
    const { value } = event.target;
    if (value.trim() === '') {
      setAirports(fakeIataAirpotsData); // Réinitialiser aux aéroports fictifs si l'input est vide
      return;
    } else {
      setQuery(value);
      // Filtrer les aéroports fictifs
      const filteredAirports = fakeIataAirpotsData.filter(airport =>
        airport.name.toLowerCase().includes(value.toLowerCase())
      );
      setAirports(filteredAirports); // Mettre à jour les aéroports avec les résultats filtrés
    }
  };

  return (
    <div className="w-[32%] px-1.5 mt-5">
      <Combobox as="div" value={query} onChange={setQuery}>
      <div className="relative">
        <ComboboxInput
            className={clsx(
              'w-full rounded-lg border-none bg-white/5 py-1.5 pr-8 pl-3 text-sm/5 text-white',
              'focus:outline-none data-[focus]:outline-2 data-[focus]:-outline-offset-2 data-[focus]:outline-white/25'
            )}
          onChange={handleChange}
          displayValue={(airport) => airport ? `${airport.name}` : ''}
          placeholder={placeholder}
        />
        <ComboboxButton className="group absolute inset-y-0 right-0 px-2.5">
            <ChevronDownIcon className="size-4 fill-white/60 group-data-[hover]:fill-white" />
          </ComboboxButton>
          </div>
        <ComboboxOptions
          anchor="bottom"
          transition
          className={clsx(
            'w-[var(--input-width)] rounded-xl border border-zinc-900 bg-zinc-900 p-1 [--anchor-gap:var(--spacing-1)] empty:invisible',
            'transition duration-100 ease-in data-[leave]:data-[closed]:opacity-0'
          )}>
          {loading && <div className="p-2">Loading...</div>}
          {airports.length === 0 && !loading && (
            <div className="p-2">No airports found.</div>
          )}
          {airports.map((airport) => (
            <ComboboxOption key={airport.id} value={airport} className="group flex cursor-default items-center gap-2 rounded-lg py-1.5 px-3 select-none data-[focus]:bg-white/10">
              <CheckIcon className="invisible size-4 fill-white group-data-[selected]:visible" />
              <div className="text-sm/6 text-white">{airport.city} - {airport.iata}</div>
            </ComboboxOption>
          ))}
        </ComboboxOptions>
      </Combobox>
    </div>
  );
};

export default AirportSearch;

