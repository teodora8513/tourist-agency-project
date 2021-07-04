import { Byte } from "@angular/compiler/src/util";
import { Destination } from "./destination.model";

export interface Hotel {
  id?: number,
  address?: string,
  name?: string,
  rating?: number,
  destination?: Destination,
  imageName?: string,
	imageFile?: string;
	image?: Byte[];
}
