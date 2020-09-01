import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../../classes/cliente';

@Component({
  selector: 'app-formulario-cliente',
  templateUrl: './formulario-cliente.component.html',
  styleUrls: ['./formulario-cliente.component.css']
})
export class FormularioClienteComponent implements OnInit {

  idInput: number;
  nombreInput: string;
  apellidoInput: string;
  direccionInput: string;
  correoInput: string;
  telefonoInput: number;
  celularInput: number;


  constructor( ) {

   }

  ngOnInit() {
  }

 /*  onAgregarCliente() {
    let cliente = new Cliente(this.idInput, this.nombreInput, this.apellidoInput, this.direccionInput, this.correoInput, this.telefonoInput, this.celularInput);
   // this.clientesService.agregarCliente(cliente);
  }
 */




}
