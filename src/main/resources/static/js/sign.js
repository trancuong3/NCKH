document.querySelector('.navbar__menu').addEventListener('click', function() {
    document.querySelector('.navbar').classList.toggle('clicked');
    document.querySelector('.navbar').classList.toggle('dis--flex');
    document.querySelector('.navbar__navr').classList.toggle( 'dis--flex');
    document.querySelector('.navbar__navl').classList.toggle( 'dis--flex');
});
