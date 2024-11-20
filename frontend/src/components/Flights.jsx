import { ArrowDownLeftIcon, ArrowUpRightIcon, ClockIcon, TicketIcon, UserIcon } from '@heroicons/react/20/solid';
import React from 'react'
import { format } from 'date-fns';

function Flights({passengerSelection, planeClasses}) {
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

  const flights = fakeIataAirpotsData.map((airport) => {
    const arrivalAirport = fakeIataAirpotsData.find(a => a.iata !== airport.iata);
    const departureDate = new Date();
    departureDate.setDate(departureDate.getDate() + Math.floor(Math.random() * 30));
    const arrivalDate = new Date(departureDate);
    arrivalDate.setHours(departureDate.getHours() + Math.floor(Math.random() * 24));
    const departureTime = format(departureDate, 'HH:mm');
    const arrivalTime = format(arrivalDate, 'HH:mm');
    return {
      departure: airport,
      arrival: arrivalAirport,
      departureDate: format(departureDate, 'dd MMM.'),
      arrivalDate: format(arrivalDate, '- dd MMM yyyy'),
      departureTime: departureTime,
      arrivalTime: arrivalTime,
      passengers: passengerSelection[Math.floor(Math.random() * passengerSelection.length)],
      planeClass: planeClasses[Math.floor(Math.random() * planeClasses.length)],
      hours: `${Math.floor((arrivalDate - departureDate) / 3600000)}h ${Math.floor(((arrivalDate - departureDate) % 3600000) / 60000)}m`,
      price: `${Math.floor(Math.random() * 100000)} XAF`,
    };
  });
  return (
  <div className="flex flex-wrap justify-center gap-4 mt-10">
    {flights.map((flight, index) => (
      <div key={index} className="w-[calc(100%/4)] rounded-md cursor-pointer overflow-hidden shadow-lg bg-zinc-800 m-4">
        <div className="px-6 py-4">
            <div className='flex items-center justify-end mb-2 text-xs'>
            {flight.departureDate} {flight.arrivalDate}
            </div>

            <div className='flex flex-col'>
            <div className='flex items-center justify-between'>
                <div className='flex items-center'>
                <ArrowUpRightIcon className='size-5 mr-2 mb-2.5 text-green-600'/>
                <h1 className="font-bold text-xl mb-2">{flight.departure.iata}</h1>
                </div>
                <p className="font-medium text-xs mb-2">{flight.departureTime}</p>
                </div>
                <p className="font-medium text-sm mb-2">{flight.departure.name}</p>
            </div>
            
            

            <div className='relative w-full h-[1px] bg-gray-600 my-4'>
                <div className='absolute -top-2.5 left-[36%] text-xs px-2 py-0.5 bg-zinc-700 rounded-lg'>{flight.planeClass.text}</div>
            </div>

            <div className='flex items-center justify-between'>
                <div className='flex items-center'>
                <ArrowDownLeftIcon className='size-5 mr-2 mb-2.5 text-green-600'/>
                <h1 className="font-bold text-xl mb-2">{flight.arrival.iata}</h1>
                </div>
                <p className="font-medium text-xs mb-2">{flight.arrivalTime}</p>
                </div>
                <p className="font-medium text-sm mb-2">{flight.arrival.name}</p>
            </div>
        <div className="px-2 pt-4 pb-2 flex items-center justify-between">
        <p className="flex items-center text-gray-50 text-xs mx-1">
           <UserIcon className='size-4 mr-1'/> {flight.passengers.text}
          </p>

          <p className="flex items-center text-gray-50 text-xs mx-1">
           <ClockIcon className='size-4 mr-1'/> {flight.hours}
          </p>
          
          <p className="flex items-center text-gray-50 text-xs mx-1">
           <TicketIcon className='size-4 mr-1'/> {flight.price}
          </p>
        </div>
      </div>
    ))}
  </div>
  )
}

export default Flights