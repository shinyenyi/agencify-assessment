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

  constructor(private phonenumbersService: PhonenumbersService) { }

  ngOnInit(): void {
    this.getCustomerPhonenumbers();
  }

  getCustomerPhonenumbers() {
    const phonenumbersRequest = new PhonenumbersRequest(null, null);
    this.subscription = this.phonenumbersService.getCustomerPhonenumbers(phonenumbersRequest).subscribe(
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

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
