import { Description, Field, Label, Select } from '@headlessui/react'
import { ChevronDownIcon } from '@heroicons/react/20/solid'
import clsx from 'clsx'

const  SelectComponent = ({options}) => {
  return (
    <div className="w-[16%] px-1.5">
      <Field>
        <div className="relative">
          <Select
            className={clsx(
              'mt-3 block w-full appearance-none rounded-lg border-none bg-white/5 py-1.5 px-3 text-sm/6 text-white',
              'focus:outline-none data-[focus]:outline-2 data-[focus]:-outline-offset-2 data-[focus]:outline-white/25',
              // Make the text of each option black on Windows
              '*:text-black'
            )}
          >
            {options.map((opt)=>(
              <option value={opt.value}>{opt.text}</option>
            ))}
          </Select>
          <ChevronDownIcon
            className="group pointer-events-none absolute top-2.5 right-2.5 size-4 fill-white/60"
            aria-hidden="true"
          />
        </div>
      </Field>
    </div>
  )
}

export default SelectComponent;
