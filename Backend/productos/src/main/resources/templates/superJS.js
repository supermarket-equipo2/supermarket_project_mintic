// Enlazar Log in con la ventana de ingresar.
const open = document.getElementById('open');
const log_in = document.getElementById('log_in');

open.addEventListener('click', () => {
    open.classList.add('show');
    alert('prueba');
});

log.addEventListener('click', () => {
    log_in.classList.remove('show');
});

$(document).ready(function() {             
    $('#loginModal').modal('show');
      $(function () {
        $('[data-toggle="tooltip"]').tooltip()
      })
    });


