import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {IArrangement} from 'src/app/common/components/model';
import {ArrangementsService} from 'src/app/services/arrangement/arrangements.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {AuthService} from 'src/app/services/authority/auth.service';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css']
})
export class AddReservationComponent implements OnInit {

  arrangements: IArrangement[];
  // Img lista ako je random mora uvek da ima duplo vise slike od broja rezervacija
  images = [1057, 944, 108, 1011, 100, 1061, 1015, 1039, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
  userId: number;

  constructor(private router: Router, private authService: AuthService,
              private arrangementsService: ArrangementsService,
              private modalService: NgbModal,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.loadArrangements();
    this.userId = this.authService.getCurrentUserValue().id;
    console.log(this.userId);


  }

  public loadArrangements(): void {
    this.arrangementsService.getAllArrangements().subscribe(
      data => {
        this.arrangements = data;
        this.arrangements.forEach(el => console.log(el));
        // filter da ako je user_id vec rezervisao taj aranzman, ne pojavljuje se
      }
    );
  }

  public reserveArrangement(arrangmentId: number): void {
    // smanji broj mesta na rezerviaciji
    // posalje mejl na email iz usera/username
    this.arrangementsService.addReservationForUser(arrangmentId, this.userId).subscribe((data) => {
      this.openSnackBar();
    });
  }

  public openSnackBar(): void{
    const message = 'You have successfuly made your reservation';
    this.snackBar.open(message.toString(), '',
      {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'center'
      });
  }

}
