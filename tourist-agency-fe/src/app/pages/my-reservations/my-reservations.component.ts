import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IArrangement } from 'src/app/common/components/model';
import { ArrangementsService } from 'src/app/services/arrangement/arrangements.service';
import { AuthService } from 'src/app/services/authority/auth.service';

@Component({
  selector: 'app-my-reservations',
  templateUrl: './my-reservations.component.html',
  styleUrls: ['./my-reservations.component.css']
})
export class MyReservationsComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService,
    private service: ArrangementsService,
    private modalService: NgbModal,
   private _snackBar: MatSnackBar) { }

   arrangements: IArrangement[];

   //Img lista ako je random mora uvek da ima duplo vise slike od broja rezervacija

   user_id :number;
   ngOnInit(): void {
     //Id je null bez auth?
     //this.user_id = this.authService.getCurrentUserValue().id;
     this.user_id = 1;
     console.log(this.user_id);
     this.loadArrangements();

   }

   loadArrangements(){
     this.service.getArrangementsByUserId(this.user_id).subscribe(
       data => {
         this.arrangements = data;
         this.arrangements.forEach(el => console.log(el));

       }
     )
   }

   cancelReservation(){
    this.openSnackBar();
   }

   openSnackBar() {
     const message= "You canceled your reservation. Please let us know why"
     this._snackBar.open(message.toString(), '',
       {duration : 3000,
       verticalPosition: 'top',
       horizontalPosition: 'center'});
   }

 }
