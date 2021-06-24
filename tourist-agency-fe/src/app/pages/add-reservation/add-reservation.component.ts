import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Arrangement } from 'src/app/common/components/model';
import { ArrangementsService } from 'src/app/services/arrangement/arrangements.service';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css']
})
export class AddReservationComponent implements OnInit {

  constructor(private router: Router, private service: ArrangementsService,
    private modalService: NgbModal) { }

  arrangements: Arrangement[];

  ngOnInit(): void {
    this.loadArrangements();
  }

  loadArrangements(){
    this.service.gettAllArrangements().subscribe(
      data => {
        this.arrangements = data;
      }
    )
  }

}
