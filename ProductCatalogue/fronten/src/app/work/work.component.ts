import { Component, OnInit } from '@angular/core';
import { UserService } from '../components/services/user.service';
@Component({
  selector: 'app-work',
  templateUrl: './work.component.html',
  styleUrls: ['./work.component.css']
})
export class WorkComponent implements OnInit {

  constructor(public userService:UserService) { }
  logout()
  {
    return this.userService.logout();
  }
  ngOnInit(): void {
  }

}
