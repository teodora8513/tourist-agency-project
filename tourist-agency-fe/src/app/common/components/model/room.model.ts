import { Hotel } from "./hotel.model";

export interface Room {
  id?: RoomIdentity,
  description?: string,
  pricePerNight?: number,
  available?: boolean,
  roomType?: RoomType,
  hotel?: Hotel
}

export interface RoomIdentity {
  hotel_id?:  number,
  room_number?: string
}

export enum RoomType {
  single_room,
  double_room,
  triple_room,
  quad_room,
  king_room
}
