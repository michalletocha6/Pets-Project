document.addEventListener("DOMContentLoaded", function () {
    let selectElementType = document.querySelector("#inputType");
    selectElementType.addEventListener('change', function () {
        let value = selectElementType.value;
        $.ajax({
            url: 'http://localhost:8080/profile/animal/breed',
            type: 'get',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            cache: false,
            data: "typeId=" + value,
            dataType: "json",
            processData: false,
            error: function () {
                console.log("error data not found")
            },
            success: function (response) {
                let $inputBreed = $("#inputBreed");
                if ($inputBreed.children().length > 1) {
                    $inputBreed.empty();
                    let optionSelect = $('<option/>');
                    optionSelect.attr({'value': ""}).text("--Please Select--");
                    $inputBreed.append(optionSelect);
                    $.each(response, function (key, entry) {
                        let option = $('<option/>');
                        option.attr({'value': entry.id}).text(entry.name);
                        $inputBreed.append(option);
                    });
                } else {
                    $.each(response, function (key, entry) {
                        let option = $('<option/>');
                        option.attr({'value': entry.id}).text(entry.name);
                        $inputBreed.append(option);
                    });
                }
            }
        });
    });
});