document.addEventListener("DOMContentLoaded", function () {
    // SELECT TYPE AND BREED-------------------------------------------------------------------------------------------
    let selectElementType = document.querySelector("#inputType");
    let $inputBreed = $("#inputBreed");
    $inputBreed.prop('disabled', true);

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
                $inputBreed.prop('disabled', false);
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