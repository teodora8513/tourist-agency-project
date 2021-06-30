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
  single_room = "Single room",
  double_room = "Double room",
  triple_room = "Triple room",
  quad_room = "Quad room",
  king_room = "King room"
}
