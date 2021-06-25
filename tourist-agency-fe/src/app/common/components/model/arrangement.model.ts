import { Hotel } from "./hotel.model";
import { Room } from "./room.model";
import { Transportation } from "./transportation.model";
import { User } from "./user.model";

export interface Arrangement {
  id?: number,
  user?: User,
  dateFrom?: Date,
  dateTo?: Date,
  numberOfNights?: number,
  rooms?: Room[],
  hotel?: Hotel,
  transportation?: Transportation,
  totalPrice?: number,
  people?: number //Broj ljudi na koje se odnosi aranzman

}

export enum Meals {
  BB = 'Bed and breakfast',
  PP = 'Half board',
  FB = 'Full board',
  ALL = 'All inclusive',
  WF = 'Without food'
}
