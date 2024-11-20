
import AirportSearch from "@/components/AirportSearch";
import SelectComponent from "@/components/Select";
import Image from "next/image";
import clsx from 'clsx'
import DatePick from "@/components/Datepick";
import Flights from "@/components/Flights";

export default function Home() {
  const tr_op= [
  {
    value: "AR",
    text: "Aller-Retour"
  },
  {
    value: "AS",
    text: "Aller Simple"
  }
]

  const passengerSelection = [
    {
      value: "1",
      text: "1 passager"
    },
    {
      value: "2",
      text: "2 passagers"
    },
    {
      value: "3",
      text: "3 passagers"
    },
    {
      value: "4",
      text: "4 passagers"
    },
    {
      value: "5",
      text: "5 passagers"
    }
  ];

  const planeClasses = [
    {
      value: "ECONOMY",
      text: "Économique"
    },
    {
      value: "PREMIUM",
      text: "Premium"
    },
    {
      value: "BUSINESS",
      text: "Affaires"
    },
    {
      value: "FIRST",
      text: "Première"
    }
  ];

  return (
    <div className="flex flex-col items-center justify-items-center  min-h-screen p-8 pb-20 sm:p-20 font-[family-name:var(--font-geist-sans)]">
      <h1 className="flex items-center text-5xl font-semibold text-zinc-300/75">
      <svg className="size-12 rotate-45 mr-1 fill-zinc-300/75 mb-1" stroke-width="1.2" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M10.5 4.5V9.16745C10.5 9.37433 10.3934 9.56661 10.218 9.67625L2.782 14.3237C2.60657 14.4334 2.5 14.6257 2.5 14.8325V15.7315C2.5 16.1219 2.86683 16.4083 3.24552 16.3136L9.75448 14.6864C10.1332 14.5917 10.5 14.8781 10.5 15.2685V18.2277C10.5 18.4008 10.4253 18.5654 10.2951 18.6793L8.13481 20.5695C7.6765 20.9706 8.03808 21.7204 8.63724 21.6114L11.8927 21.0195C11.9636 21.0066 12.0364 21.0066 12.1073 21.0195L15.3628 21.6114C15.9619 21.7204 16.3235 20.9706 15.8652 20.5695L13.7049 18.6793C13.5747 18.5654 13.5 18.4008 13.5 18.2277V15.2685C13.5 14.8781 13.8668 14.5917 14.2455 14.6864L20.7545 16.3136C21.1332 16.4083 21.5 16.1219 21.5 15.7315V14.8325C21.5 14.6257 21.3934 14.4334 21.218 14.3237L13.782 9.67625C13.6066 9.56661 13.5 9.37433 13.5 9.16745V4.5C13.5 3.67157 12.8284 3 12 3C11.1716 3 10.5 3.67157 10.5 4.5Z" stroke-width="1.2" stroke-linecap="round" stroke-linejoin="round"></path></svg>

      Flight Go
      </h1>

      <div className="relative flex flex-col w-[68%] pt-4 pb-10 px-1 rounded-lg bg-zinc-800 ring-1 ring-gray-900/10 my-10">
        <div className="w-full flex items-center justify-start">
        <SelectComponent options={tr_op}/>
        <SelectComponent options={passengerSelection}/>
        <SelectComponent options={planeClasses}/>
        </div>

        <div className="w-full flex items-center justify-start">
        <AirportSearch placeholder={"Aéroport de départ"}/>
        <AirportSearch placeholder={"Aéroport de d'arrivé"}/>

        <div
        className={clsx(
        'mt-5 block w-[34%] appearance-none rounded-lg border-none bg-white/5 py-1.5 px-0.5 text-sm/4 text-white',
        'focus:outline-none data-[focus]:outline-2 data-[focus]:-outline-offset-2 data-[focus]:outline-white/25'
        )}
        >
          <div className="flex items-center px-1">
          {/* <Label className="text-sm/3 font-medium text-white mr-1">Départ</Label> */}
        <DatePick placeholder="Date de depart" id="depart"/>
        <DatePick placeholder="Date de retour" id="retour"/>
          </div>

        </div>
        </div>
        <button className="absolute -bottom-5 left-[45%] min-w-28 py-1.5 px-3 bg-green-600 text-white font-bold rounded-xl hover:bg-green-700 transition duration-300 ring-1 ring-[#0a0a0a]">
          Rechercher
        </button>
      </div>

      <Flights passengerSelection={passengerSelection} planeClasses={planeClasses}/>
    </div>
  );
}
