import { Destination } from "./destination.model";

export interface Hotel {
  id?: number,
  address?: string,
  name?: string,
  rating?: number,
  destination?: Destination
}
