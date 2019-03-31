var toast = function (params) {
    var el = document.createElement("div");
    el.setAttribute("id", "toast");
    el.innerHTML = params.message;
    document.body.appendChild(el);
    el.classList.add("fadeIn");
    setTimeout(function () {
        el.classList.remove("fadeIn");
        el.classList.add("fadeOut");
        el.addEventListener("animationend", function () {
            el.classList.add("hide");
        });
    }, params.time);
};