import { DatePipe } from '@angular/common';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IArrangement } from 'src/app/common/components/model';
import { ArrangementsService } from 'src/app/services/arrangement/arrangements.service';
import { ToastService } from 'src/app/services/toast/toast.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css']
})
export class AddReservationComponent implements OnInit {

  constructor(private router: Router, private service: ArrangementsService,
    private modalService: NgbModal,
    private _snackBar: MatSnackBar) { }

  arrangements: IArrangement[];
  //Img lista ako je random mora uvek da ima duplo vise slike od broja rezervacija
  images = [1057,944,108, 1011,100,1061, 1015, 1039, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
  ngOnInit(): void {
    this.loadArrangements();
  }

  loadArrangements(){
    this.service.getAllArrangements().subscribe(
      data => {
        this.arrangements = data;
      }
    )
  }

  reserveArrangement(){
    this.openSnackBar();


  }
  openSnackBar() {
    const message= "You have successfuly made your reservation"
    this._snackBar.open(message.toString(), '',
      {duration : 3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'});
  }

}
