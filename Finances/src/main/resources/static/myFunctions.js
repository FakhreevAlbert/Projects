function setAll() {
    localStorage.setItem('sort', "ALL");
}

function f(sort) {
    localStorage.setItem('sort', sort);
}

function getSort(financeType) {
    var result = localStorage.getItem('sort');
    if (result != null) {
        location.href = "http://localhost:8081/" + financeType + "/" + result;
        localStorage.removeItem('sort');
    } else {
        location.href = "http://localhost:8081/" + financeType + "/" + "ALL";
    }
}