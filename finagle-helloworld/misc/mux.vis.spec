{
    "variables": [
        {
            "name": "start_time",
            "type": "PX_STRING",
            "description": "The start time of the window in time units before now.",
            "defaultValue": "-5m"
        },
        {
            "name": "max_num_records",
            "type": "PX_INT64",
            "description": "Max number of records to show.",
            "defaultValue": "1000"
        }
    ],
    "globalFuncs": [
        {
            "outputName": "mux_data",
            "func": {
                "name": "mux_data",
                "args": [
                    {
                        "name": "start_time",
                        "variable": "start_time"
                    },
                    {
                        "name": "num_head",
                        "variable": "max_num_records"
                    }
                ]
            }
        }
    ],
    "widgets": [
        {
            "name": "Table",
            "position": {
                "x": 0,
                "y": 0,
                "w": 12,
                "h": 4
            },
            "globalFuncOutputName": "mux_data",
            "displaySpec": {
                "@type": "types.px.dev/px.vispb.Table"
            }
        }
    ]
}

