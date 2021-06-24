import { Destination } from "./destination.model";

export interface Transportation{
  id?: number,
  type?: TransportationType,
  season?: Season,
  startDestination?: Destination,
  endDestination?: Destination,
  prica?: number
}

export enum TransportationType{
  BUS = 'Bus',
  CAR = 'Car',
  PLANE = 'Plane',
  MINI_BUS = 'Mini bus'
}

export enum Season{
  WINTER = 'Winter',
   SPRING = 'Spring',
    SUMMER = 'Summer',
     AUTUMN = 'Autumn'
}
