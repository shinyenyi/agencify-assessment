import { Component, OnDestroy, OnInit } from '@angular/core';
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

  constructor(private phonenumbersService: PhonenumbersService) { }

  ngOnInit(): void {
    this.getCustomerPhonenumbers();
  }

  getCustomerPhonenumbers() {
    const phonenumbersRequest = new PhonenumbersRequest(null, null);
    this.subscription = this.phonenumbersService.getCustomerPhonenumbers(phonenumbersRequest).subscribe(
      data => { this.customerPhonenumbers = data },
      error => { },
      () => { }
    );
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
