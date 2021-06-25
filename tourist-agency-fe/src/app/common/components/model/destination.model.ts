export interface Destination {
  id?: number,
  name?: string,
  postalCode?: number,
  state?: State
}

export interface State {
  id?:  string,
  name?: string
}
