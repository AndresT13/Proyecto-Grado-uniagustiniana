import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/classes/usuario';
import { HttpClientService } from '../../services/http-client.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {


 private  usuarios: Usuario[];


  constructor(private usuarioService: HttpClientService) { }

  ngOnInit() {
     this.usuarioService.getUsuarios().subscribe(
      usuarios => this.usuarios = usuarios
      );
  }


  delete(usuario: Usuario): void {

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al usuario:  ${usuario.nombre}, del tipo:  ${usuario.id}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {


        this.usuarioService.delete(usuario.id).subscribe(
          response => {
            this.usuarios = this.usuarios.filter(usu => usu !== usuario)
            swalWithBootstrapButtons.fire(
              'Cliente Eliminado!',
              `Cliente ${usuario.nombre} eliminado con éxito.`,
              'success'
            )

          }
        )
      }
    })

  }
}
