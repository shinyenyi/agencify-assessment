import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs/internal/Subscription';
import { PhonenumbersRequest } from './phonenumbers-request-response';
import { PhonenumbersService } from './phonenumbers.service';

@Component({
  selector: 'app-phonenumbers',
  templateUrl: './phonenumbers.component.html',
  styleUrls: ['./phonenumbers.component.scss']
})
export class PhonenumbersComponent implements OnInit, OnDestroy {

  subscription: Subscription = new Subscription();
  customerPhonenumbers: string[] = [];
  displayedColumns: string[] = ['#', 'phone'];
  dataSource = new MatTableDataSource<string>(this.customerPhonenumbers);

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  countryCode: string = "";
  state: string = "";
  phonenumbersRequest = new PhonenumbersRequest(null, null);

  constructor(private phonenumbersService: PhonenumbersService) { }

  ngOnInit(): void {
    this.getCustomerPhonenumbers();
  }

  getCustomerPhonenumbers() {
    this.subscription = this.phonenumbersService.getCustomerPhonenumbers(this.phonenumbersRequest).subscribe(
      {
        next: (data) => { this.customerPhonenumbers = data },
        error: (error) => { },
        complete: () => {
          this.dataSource = new MatTableDataSource<string>(this.customerPhonenumbers);
          this.ngAfterViewInit();
        }
      }
    );
  }

  filterByCountry() {
    this.state = "";
    this.phonenumbersRequest = new PhonenumbersRequest(this.countryCode, null);
    this.getCustomerPhonenumbers();
  }

  refresh() {
    window.location.reload();
  }

  filterByState() {
    this.countryCode = "";
    if (this.state === "valid") {
      this.phonenumbersRequest = new PhonenumbersRequest(null, true);
    }
    if (this.state === "invalid") {
      this.phonenumbersRequest = new PhonenumbersRequest(null, false);
    }
    this.getCustomerPhonenumbers();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
