
import AirportSearch from "@/components/AirportSearch";
import SelectComponent from "@/components/Select";
import Image from "next/image";
import clsx from 'clsx'
import DatePick from "@/components/Datepick";

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
      <h1 className="text-5xl font-semibold text-zinc-300/75">Flight Go</h1>

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
    </div>
  );
}
