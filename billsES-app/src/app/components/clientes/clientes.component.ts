import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/classes/cliente';


@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  // tslint:disable-next-line: whitespace
  clientes: Cliente[];

  constructor() { }

  ngOnInit() {

  }

}
