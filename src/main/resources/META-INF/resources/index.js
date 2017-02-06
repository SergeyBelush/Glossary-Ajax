$(document).ready(function () {
    $('#add-search').click(function () {
        var requestData = $('#search').val();
        var resultElement = $('#result');

        resultElement.empty();

        if (requestData==null || requestData=="") {
            alert('Please enter the part of the word or description!!!');
        } else {
            $.ajax({
                url: 'http://localhost:8080/search',
                method: 'get',

                data: {search: requestData},
                dataType: 'json',
                success: function (data) {

                    resultElement.empty();

                    data.forEach(function (item) {
                        var s = "<p> Word: " + item.word + "</p> <p>Description: " + item.description + "</p><br/>";
                        resultElement.append(s);
                    });
                }
            });
        }
    });
});

$(document).ready(function(){

    $('#add-word').on('click', function(e) {
        e.preventDefault();
        var word = $('#word').val();
        var description = $('#description').val();

        $.ajax({
            url: 'addGlossary',
            data: JSON.stringify({
                "word" : word,
                "description" :description
            }),
            type: 'POST',
            contentType: 'application/json',
            success: function (data){
                var $table = $('#glossary-table');
                $table.append(
                    $('<tbody/>').append(
                        $('<tr/>')
                            .append(
                                $('<td/>', {
                                        style: "width: 200px",
                                        text: word
                                    }
                                )
                            ).append(
                            $('<td/>', {
                                    style: "width: 200px",
                                    text: description
                                }
                            )
                        )
                    )
                )
            },
            error: function (xhr, status, err){
                console.log(err);
            }
        });
    });
});


function Home() {};

Home.prototype.updatePage = function () {
    $.ajax({
        url: 'home',
        dataType: 'json',
        type: 'GET',
        success: function (data, textStatus) {
            var $table = $('#glossary-table');
            $.each(data, function (i, val) {
                $table.append(
                    $('<tbody/>').append(
                        $('<tr/>')
                            .append(
                                $('<td/>', {
                                        style: "width: 200px",
                                        text: val.word
                                    }
                                )
                            ).append(
                            $('<td/>', {
                                    style: "width: 200px",
                                    text: val.description
                                }
                            )
                        )
                    )
                )
            });
        }
    });
}

var home = new Home();
home.updatePage();